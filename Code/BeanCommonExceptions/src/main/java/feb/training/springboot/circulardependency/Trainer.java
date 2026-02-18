package feb.training.springboot.circulardependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Trainer {
    @Autowired
	Student student;
}
