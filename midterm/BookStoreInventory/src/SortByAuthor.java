import java.util.Comparator;

/**
 * A functional class that can be passed as a parameter to list.sort()
 * <p>
 * Uses Comparable<T> built-in interface and return value conventions
 */
public class SortByAuthor implements Comparator<BookStoreItem> {

  /**
   * Implements Comparator for BookStoreItem as alphabetical by author last name
   * <p>
   * @param pub1 the first BookStoreItem to be compared
   * @return int: -1 if pub1 < pub2, 0 if equals, +1 if pub1 > pub2
   * Relies on natural (lexicographic) built-in order for String
   */
  @Override
  public int compare(BookStoreItem pub1, BookStoreItem pub2) {
    String author1 = pub1.getAuthor().getLastName();
    String author2 = pub2.getAuthor().getLastName();
    return author1.compareTo(author2);
  }
}
