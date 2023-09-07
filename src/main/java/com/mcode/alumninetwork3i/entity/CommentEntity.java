package com.mcode.alumninetwork3i.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "comments")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentEntity extends BaseEntity {

    @Column(length = 1024)
    private String content;
    private Integer likeCount;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dateCreated;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dateLastModified;

    @OneToOne
    @JoinColumn(name = "author_id", nullable = false)
    private UserEntity author;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private PostEntity post;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "comment_likes",
            joinColumns = @JoinColumn(name = "comment_id"),
            inverseJoinColumns = @JoinColumn(name = "liker_id")
    )
    private List<UserEntity> likeList = new ArrayList<>();

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        CommentEntity comment = (CommentEntity) object;
        return Objects.equals(id, comment.id) && Objects.equals(author, comment.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author);
    }
}

