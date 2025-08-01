package insane.inoteserver.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "task_lists")
@IdClass(TaskListId.class)
public class TaskList {


    @Column(name = "list_name", nullable = false)
    private String listName;

    @Id
    @Column(name = "create_time", nullable = false)
    private long createTime;

    @Id
    @JoinColumn(name = "user", referencedColumnName = "id", nullable = false)
    private String user;

}


