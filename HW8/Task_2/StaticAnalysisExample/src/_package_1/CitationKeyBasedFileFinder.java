package _package_1;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class CitationKeyBasedFileFinder {
	private final boolean exactKeyOnly;

    CitationKeyBasedFileFinder(boolean exactKeyOnly) {
        this.exactKeyOnly = exactKeyOnly;
    }

    public List<Path> findAssociatedFiles(BibEntry entry, List<Path> directories, List<String> extensions) throws IOException {
        Objects.requireNonNull(directories);
        Objects.requireNonNull(entry);
        String citeKey;

        Optional<String> citeKeyOptional = entry.getCitationKey();
        if (StringUtil.isBlank(citeKeyOptional)) {
            return Collections.emptyList();
        }
        if (citeKeyOptional.isPresent()) {

        citeKey = citeKeyOptional.get();

        } else {
            citeKey = "";
        }

        List<Path> result = new ArrayList<>();

        // First scan directories
        Set<Path> filesWithExtension = findFilesByExtension(directories, extensions);

        // Now look for keys
        for (Path file : filesWithExtension) {
            String name = file.getFileName().toString();
            String nameWithoutExtension = FileUtil.getBaseName(name);

            // First, look for exact matches
            if (nameWithoutExtension.equals(citeKey)) {
                result.add(file);
                continue;
            }
            // If we get here, we did not find any exact matches. If non-exact matches are allowed, try to find one
            if (!exactKeyOnly && matches(name, citeKey)) {
                result.add(file);
            }
        }

        return result.stream().sorted().collect(Collectors.toList());
    }

    private boolean matches(String filename, String citeKey) {
        if (filename.startsWith(citeKey)) {
            // The file name starts with the key, that's already a good start
            // However, we do not want to match "JabRefa" for "JabRef" since this is probably a file belonging to another entry published in the same time / same name
            char charAfterKey = filename.charAt(citeKey.length());
            return !((List<Path>) CitationKeyGenerator.APPENDIX_CHARACTERS).contains(Character.toString(charAfterKey));
        }
        
        
        return false;
    }

    /**
     * Returns a list of all files in the given directories which have one of the given extension.
     */
    private Set<Path> findFilesByExtension(List<Path> directories, List<String> extensions) throws IOException {
        Objects.requireNonNull(extensions, "Extensions must not be null!");

        BiPredicate<Path, BasicFileAttributes> isFileWithCorrectExtension = (path, attributes) -> !Files.isDirectory(path)
                && extensions.contains(FileHelper.getFileExtension(path).orElse(""));

        Set<Path> result = new HashSet<>();
        for (Path directory : directories) {
            if (Files.exists(directory)) {
                try (Stream<Path> pathStream = Files.find(directory, Integer.MAX_VALUE, isFileWithCorrectExtension, FileVisitOption.FOLLOW_LINKS)) {
                    result.addAll(pathStream.collect(Collectors.toSet()));
                } catch (UncheckedIOException e) {}
                }
            }
        
        return result;
    }

}
