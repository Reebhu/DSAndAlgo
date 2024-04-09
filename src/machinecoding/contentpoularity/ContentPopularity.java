package machinecoding.contentpoularity;

public class ContentPopularity {
	private String contentId;
	private Integer popularity;
	private final Long timestamp;

	public ContentPopularity(String contentId, Integer popularity) {
		this.contentId = contentId;
		this.popularity = popularity;
		this.timestamp = System.currentTimeMillis();
	}

	public String getContentId() {
		return contentId;
	}

	public void setContentId(String contentId) {
		this.contentId = contentId;
	}

	public Integer getPopularity() {
		return popularity;
	}

	public void setPopularity(Integer popularity) {
		this.popularity = popularity;
	}

	public Long getTimestamp() {
		return timestamp;
	}
}
