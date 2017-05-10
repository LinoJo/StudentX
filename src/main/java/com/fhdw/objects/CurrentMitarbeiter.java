package com.fhdw.objects;

import com.fhdw.enums.Role;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

/**
 * Created by Timon Caspari on 10.05.2017.
 */
public class CurrentMitarbeiter extends User{

    private Mitarbeiter mitarbeiter;

    public Mitarbeiter getMitarbeiter() {
        return mitarbeiter;
    }

    public CurrentMitarbeiter(Mitarbeiter mitarbeiter) {
        super(mitarbeiter.getEmail(), mitarbeiter.getPasswort(), AuthorityUtils.createAuthorityList(mitarbeiter.getRole().toString()));
        this.mitarbeiter = mitarbeiter;
    }

    public Role getRole(){
        return mitarbeiter.getRole();
    }
}
