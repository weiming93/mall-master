package com.blueocean.mall.common.auditing;

import com.blueocean.mall.common.DateUtil;
import com.blueocean.mall.common.model.User;
import com.blueocean.mall.common.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.parameters.P;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Transactional
@SpringBootTest
public class DateAuditTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testGenerated(){
        User user = new User();
        user = userRepository.save(user);
        assertNotNull(user.getId());
    }

    @Test
    public void userCreation(){
        User user = new User();
        user = userRepository.save(user);

        assertEquals(DateUtil.getDateByInstant(user.getCreatedAt()),"2019-12-15");
        assertEquals(DateUtil.getDateByInstant(user.getUpdatedAt()),"2019-12-15");
    }


}
