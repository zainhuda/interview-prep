import java.io.File;

import java.nio.file.Files;
import java.nio.file.Path;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// wow this is a hard one 

public static class FilePaths {

    private Path duplicatePath;
    private Path originalPath;

    public FilePaths(Path duplicatePath, Path originalPath) {
        this.duplicatePath = duplicatePath;
        this.originalPath  = originalPath;
    }

    public Path getDuplicatePath() {
        return duplicatePath;
    }

    public Path getOriginalPath() {
        return originalPath;
    }

    @Override
    public String toString() {
        return String.format("(duplicate: %s, original: %s)", duplicatePath, originalPath);
    }
}

// storing info 
private static class FileInfo {
    long timeLastEdited;
    Path path;
    FileInfo(long timeLastEdited, Path path) {
        this.timeLastEdited = timeLastEdited;
        this.path = path;
    }
} 

public static List<FilePaths> findDuplicateFiles(Path startingDirectory) {
    Map<String, FileInfo> fileSeen = new HashMap<>();
    Deque<Path> stack = new ArrayDeque<>();
    stack.push(startingDirectory);
    List<FilePaths> duplicates = new ArrayList<>();
    
    // iterative sol
    while (!stack.isEmpty()) {
        Path curr = stack.pop();
        File currFile = new File(curr.toString());
        
        if (currFile.isDirectory()) {
            for (File file : currFile.listFiles()) {
                stack.push(file.toPath());
            }
        } else {
            String fileHash;
            try {
                fileHash = sampleHashFile(currentPath);
            } catch (IOException | NoSuchAlgorithmException e) {
                e.printStackTrace();
                continue;
            }
            
            long currLastEditedTime = currFile.lastModified();
            if (filesSeen.containsKey(fileHash)) {
                FileInfo fileInfo = filesSeen.get(fileHash);
                long existLastEditedTime = fileInfo.timeLastEdited;
                Path existingPath = fileInfo.path;
                if (currLastEditedTime > existLastEditedTime) {
                    duplicates.add(new FilePaths(curr, existingPath));
                } else {
                    duplicates.add(new FilePaths(existingPath, curr));
                    fileSeen.put(fileHash, new FileInfo(currLastEditedTime, curr);
                }
            } else {
                fileSeen.put(fileHash, new FileInfo(currLastEditedTime, curr));
            }
        }
    }
    return duplicates;
}

// this hashing func in an interview!!!
// 4000 block size, same as a mac

private static final int SAMPLE_SIZE = 4000;
private static String simpleHashFile(Path path) {
    file long totalBytes = new File(path.toString()).length();
    
    try (InputStream inputStrea = new FileInputStream(path.toString())) {
        MessageDigest digest = MessageDigest.getInstance("SHA-512");
        DigestInputStream digestInputStream = new DigestInputStream(inputStream, digest);

        // if the file is too short to take 3 samples, hash the entire file
        if (totalBytes < SAMPLE_SIZE * 3) {
            byte[] bytes = new byte[(int) totalBytes];
            digestInputStream.read(bytes);
        } else {
            byte[] bytes = new byte[SAMPLE_SIZE * 3];
            long numBytesBetweenSamples = (totalBytes - SAMPLE_SIZE * 3) / 2;

            // read first, middle and last bytes
            for (int n = 0; n < 3; n++) {
                digestInputStream.read(bytes, n * SAMPLE_SIZE, SAMPLE_SIZE);
                digestInputStream.skip(numBytesBetweenSamples);
            }
        }
        return new BigInteger(1, digest.digest()).toString(16);
    }
}




