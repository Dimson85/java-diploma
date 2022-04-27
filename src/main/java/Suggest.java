import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Suggest {
    private final String keyWord;
    private final String title;
    private final String url;

    public Suggest(String keyWord, String title, String url) {
        this.keyWord = keyWord;
        this.title = title;
        this.url = url;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Suggest)) return false;
        Suggest suggest = (Suggest) o;
        return Objects.equals(getKeyWord(), suggest.getKeyWord()) && Objects.equals(getTitle(), suggest.getTitle()) && Objects.equals(getUrl(), suggest.getUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getKeyWord(), getTitle(), getUrl());
    }

    @Override
    public String toString() {
        return "Suggest{" +
                "keyWord='" + keyWord + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
