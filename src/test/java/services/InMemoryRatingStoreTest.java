package services;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

import static org.assertj.core.api.Assertions.assertThat;

public class InMemoryRatingStoreTest {

  @Test
  public void add() throws InterruptedException {
    InMemoryRatingStore ratingStore = new InMemoryRatingStore();
    List<Callable<Rating>> tasks = new LinkedList<>();
    String laptopId = UUID.randomUUID().toString();
    double score = 5;

    int n = 10;
    for (int i = 0; i < n; i++) {
      tasks.add(() -> ratingStore.Add(laptopId, score));
    }

    Set<Integer> ratedCount = new HashSet<>();
    Executors.newWorkStealingPool()
        .invokeAll(tasks)
        .stream()
        .forEach(future -> {
          try {
            Rating rating = future.get();
            assertThat(rating.getSum()).isEqualTo(rating.getCount() * score);
            ratedCount.add(rating.getCount());
          } catch (Exception e) {
            throw new IllegalStateException();
          }
        });
    assertThat(n).isEqualTo(ratedCount.size());
    for (int cnt = 1; cnt <= n; cnt++) {
      assertThat(ratedCount.contains(cnt)).isTrue();
    }
  }
}