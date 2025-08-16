package insane.inoteserver.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tasks")
@IdClass(TaskId.class)
public class Task {
    @Column(name = "is_over", nullable = false)
    private Boolean isOver;

    @Column(name = "body", nullable = false, columnDefinition = "TEXT")
    private String body;

    @Id
    @Column(name = "create_time", nullable = false)
    private Long createTime;


    @Column(name = "remind_time")
    private Long remindTime;

    @Column(name = "over_time")
    private Long overTime;

    @Column(name = "repeat_period", nullable = false)
    private Long repeatPeriod;

    @JoinColumn(name = "task_list_id", nullable = false)
    private Long taskListId;

    @Id
    @JoinColumn(name = "user", referencedColumnName = "id", nullable = false)
    private String user;

}


