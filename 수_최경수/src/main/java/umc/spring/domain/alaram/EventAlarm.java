package umc.spring.domain.alaram;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("EVENT")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EventAlarm extends Alarm {
  @Column(nullable = false, length = 30)
  private String title;

  @Column(columnDefinition = "TEXT")
  private String content;

  private boolean isPermission;
}
