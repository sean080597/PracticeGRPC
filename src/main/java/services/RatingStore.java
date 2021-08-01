package services;

public interface RatingStore {
  Rating Add(String laptopID, double score);
}
