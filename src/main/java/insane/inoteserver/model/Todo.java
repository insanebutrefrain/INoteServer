package insane.inoteserver.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "todos")
@IdClass(TodoId.class)
public class Todo {

    @Column(name = "is_over", nullable = false)
    private Boolean isOver;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String body;

    @Id
    @Column(name = "create_time", nullable = false)
    private Long createTime;

    @Column(name = "remind_time")
    private long remindTime = 0;

    @Column(name = "over_time")
    private Long overTime;

    @Column(name = "repeat_period", nullable = false)
    private Long repeatPeriod;

    @Id
    @JoinColumn(name = "user", referencedColumnName = "id", nullable = false)
    private String user;
}



