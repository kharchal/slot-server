package ua.com.hav.slotserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.hav.slotserver.exception.IconNotFoundException;
import ua.com.hav.slotserver.model.Icon;
import ua.com.hav.slotserver.repository.IconRepository;

@Service
public class IconService {

    @Autowired
    private IconRepository iconRepository;

    public Icon findByValue(char ch) {
//        String c = "" + ch;
        return iconRepository.findByValue(ch)
                .orElseThrow(() -> new IconNotFoundException(ch));
    }
}
