package diyor.adashev.Database;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vazifa {
    private int id;
    private String name;
    private String sana;
    private String status;
}
