package com.fhdw.services.security;

import com.fhdw.objects.CurrentMitarbeiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by Timon Caspari on 10.05.2017.
 */
@Service
public class MitarbeiterDetailsService implements UserDetailsService{
    @Autowired
    private MitarbeiterService mitarbeiterService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return new CurrentMitarbeiter(mitarbeiterService.getMitarbeiterByEmail(email));
    }
}
