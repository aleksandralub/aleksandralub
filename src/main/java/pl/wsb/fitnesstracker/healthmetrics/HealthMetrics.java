package pl.wsb.fitnesstracker.healthmetrics;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.wsb.fitnesstracker.user.api.User;

import java.time.LocalDate;

@Entity
@Table(name = "Health_Metrics")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HealthMetrics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "weight", nullable = false)
    private double weight;

    @Column(name = "health", nullable = false)
    private double health;

    @Column(name = "heart_rate", nullable = false)
    private int heartRate;

    public HealthMetrics(User user, LocalDate date, double weight, double health, int heartRate) {
        this.user = user;
        this.date = date;
        this.weight = weight;
        this.health = health;
        this.heartRate = heartRate;
    }
}
