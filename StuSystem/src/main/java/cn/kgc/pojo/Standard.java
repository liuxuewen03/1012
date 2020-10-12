package cn.kgc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Standard {
    private Integer id;

    private String stdNum;

    private String zhname;

    private String version;

    private String keys;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date releaseDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date implDate;

    private String packagePath;

}