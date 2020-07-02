package case_study.module2_wbe.converter;
import org.springframework.core.convert.converter.Converter;
import java.time.LocalDate;

public class BirthdayDateConverter implements Converter<String, LocalDate> {
    String regex = "^(\\d{4}-\\d{2}-\\d{2})$";
    @Override
    public LocalDate convert(String source) {
        if(source.equals("")||!source.matches(regex)){
            return null;
        }else {
            try {
                return LocalDate.parse(source);
            }catch (Exception e){
                return null;
            }
        }
    }
}
