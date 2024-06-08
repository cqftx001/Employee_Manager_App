package tech.kevin.employee_manager.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileStorageService {

    private final Path fileStorageLocation = Paths.get("path/to/upload/directory");

    public String storeFile(MultipartFile file) {
        try {
            String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
            Path targetLocation = fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation);

            // Return the URL or file path to access the file
            return "http://localhost:8080/files/" + fileName;
        } catch (Exception ex) {
            throw new RuntimeException("Could not store file " + file.getOriginalFilename() + ". Please try again!", ex);
        }
    }
}
