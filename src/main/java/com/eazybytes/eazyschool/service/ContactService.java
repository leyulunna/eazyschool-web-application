package com.eazybytes.eazyschool.service;

import com.eazybytes.eazyschool.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ContactService {

    public boolean saveMsgDetail(Contact contact) {
        boolean isSave = true;
        log.info(contact.toString());
        return isSave;
    }
}
