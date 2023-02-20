package com.example.security_form.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Table;
import org.springframework.data.annotation.Id;


@Data
@NoArgsConstructor
@Entity
@Table(appliesTo = "Person")
public class Person {
    @jakarta.persistence.Id
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, name = "login")
    private String login;
    @Column(nullable = false, name = "password")
    private String password;

    public Person(String login, String password) {
        this.login = login;
        this.password = password;
    }

    //    @OneToMany(cascade = CascadeType.ALL) // // удалятся все файлы при удалении пользователя
//    private List<File> files = new ArrayList<>();

    // добавляем пользователю файл в список
//    public void addFileToPerson(File file) {
//        file.setPerson(this);
//        files.add(file);
//    }
}