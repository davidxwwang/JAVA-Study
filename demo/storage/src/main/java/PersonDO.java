import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class PersonDO {

    @Setter
    @Getter
    private Integer id;

    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    private String home_town;

    @Setter
    @Getter
    private Integer sex;

    @Setter
    @Getter
    private String height;
}
