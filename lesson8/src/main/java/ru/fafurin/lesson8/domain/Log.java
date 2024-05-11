package ru.fafurin.lesson8.domain;

import jakarta.persistence.Id;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "logs")
@Data
public class Log {
    @Id
    private ObjectId id;
    private String method;
    private String result;
    private LocalDateTime createdAt;

    public Log(String method, String result) {
        this.method = method;
        this.result = result;
        this.createdAt = LocalDateTime.now();
    }

    public void print() {
        System.out.println("-----------------------------");

        System.out.print("Id: ");
        System.out.print(Color.BLUE_UNDERLINED);
        System.out.println(this.getId());
        System.out.print(Color.RESET);

        System.out.print("Method: ");
        System.out.print(Color.MAGENTA_BOLD_BRIGHT);
        System.out.println(this.getMethod());
        System.out.print(Color.RESET);

        System.out.print("Result: ");
        System.out.print(Color.GREEN_BOLD_BRIGHT);
        System.out.println(this.getResult());
        System.out.print(Color.RESET);

        System.out.print("CreatedAt: ");
        System.out.print(Color.RED_BOLD_BRIGHT);
        System.out.println(this.getCreatedAt());
        System.out.print(Color.RESET);
        System.out.println("-----------------------------");
    }
}
