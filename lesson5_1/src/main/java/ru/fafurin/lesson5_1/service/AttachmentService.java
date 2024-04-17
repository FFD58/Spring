package ru.fafurin.lesson5_1.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import ru.fafurin.lesson5_1.entity.Attachment;
import ru.fafurin.lesson5_1.repository.AttachmentRepository;

import java.io.IOException;

@Service
@AllArgsConstructor
public class AttachmentService {

    private final AttachmentRepository attachmentRepository;

    public Attachment saveAttachment(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            Attachment attachment = new Attachment(fileName, file.getContentType(), file.getBytes());
            return attachmentRepository.save(attachment);
        } catch (IOException e) {
            throw new RuntimeException("Could not save file: " + fileName);
        }
    }

    public Attachment getAttachment(Integer fileId) {
        return attachmentRepository.findById(fileId).orElseThrow(
                () -> new RuntimeException(String.format("File with id %d not found", fileId))
        );
    }
}
