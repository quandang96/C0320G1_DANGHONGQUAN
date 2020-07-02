package case_study.module2_wbe.converter;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDateTime;

public class DateConverter implements Converter<String, LocalDateTime> {
    @Override
    public LocalDateTime convert(String source) {

        if (source.equals("") ) {
            return null;
        } else {
            try {
                return LocalDateTime.parse(source);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
