package com.fhdw.config;

import com.fhdw.enums.Role;
import com.fhdw.interfaces.MitarbeiterRepo;
import com.fhdw.objects.Mitarbeiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Created by Timon Caspari on 10.05.2017.
 */
@Component
public class DefaultLoader implements ApplicationListener<ContextRefreshedEvent>{

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private MitarbeiterRepo mitarbeiterRepo;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(!mitarbeiterRepo.exists("admin")){
            Mitarbeiter m = new Mitarbeiter();
            m.setEmail("admin");
            m.setVorname("Admin");
            m.setNachname("istrator");
            m.setPasswort(passwordEncoder.encode("password"));
            m.setRole(Role.ROLE_ADMIN);

            mitarbeiterRepo.save(m);
        }
    }
}
