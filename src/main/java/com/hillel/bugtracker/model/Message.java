package com.hillel.bugtracker.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private int messageId;

    @ManyToOne(cascade = {
            CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH
    })
    @JoinColumn(name = "ticket_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Ticket ticket;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private User author;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private User recipient;


    @NotBlank(message = "must be not blank")
    private String text;

    @CreationTimestamp
    private LocalDateTime createDate;

    @UpdateTimestamp
    private LocalDateTime updateDate;

}
