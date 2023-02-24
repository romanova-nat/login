package com.example.security_form.service;

import com.example.security_form.model.Person;
import com.example.security_form.repository.PersonRepository;
import com.example.security_form.security.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.Optional;

@Service
public class PersonDetailService implements UserDetailsService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonDetailService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> person = personRepository.findByLogin(username);

        if (person.isEmpty()){
            throw new UsernameNotFoundException("Пользователь не найден");
        }
        return new PersonDetails(person.get()); //оборачиваем в PersonDetails и возвращаем
    }

//    public UserDetails getAuthorities(String user, String password) {
//        Optional<Person> person = personRepository.findByLoginAndPassword(user, password);
//        if (user.isEmpty() || password.isEmpty()) {
//            throw new UsernameNotFoundException ("Логин или пароль пустые");
//        }
//        return new PersonDetails(person.get()); //оборачиваем в PersonDetails и возвращаем
//    }
}
