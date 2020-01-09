package com.hillel.bugtracker.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tickets")
@Data
@NoArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private int ticketId;

    @Column(name = "title")
    @EqualsAndHashCode.Exclude
    private String title;

    @OneToMany(mappedBy = "ticket", cascade = {
            CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Message> messages;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private User creator;

    @ManyToOne
    @JoinColumn(name = "holder_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private User holder;

    @CreationTimestamp
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private LocalDateTime createDate;

    @UpdateTimestamp
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private LocalDateTime updateDate;

}
