package machinecoding.contentpoularity;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;

public class ContentPopularityService {

	Map<String, ContentPopularity> POPULARITY_STORE = new ConcurrentHashMap<>();
	PriorityQueue<ContentPopularity> QUEUE = new PriorityQueue<>(new Comparator<ContentPopularity>() {
		@Override
		public int compare(ContentPopularity o1, ContentPopularity o2) {
			if (o2.getPopularity() > o1.getPopularity())
				return 1;
			else if (o1.getPopularity() > o2.getPopularity())
				return -1;
			return (int) (o2.getTimestamp() - o1.getTimestamp());
		}
	});

	public void makePopular(String contentId) {
		ContentPopularity contentPopularity = POPULARITY_STORE.getOrDefault(contentId, new ContentPopularity(contentId, 0));
		QUEUE.remove(contentPopularity);
		contentPopularity.setPopularity(contentPopularity.getPopularity() + 1);
		QUEUE.offer(contentPopularity);
		POPULARITY_STORE.put(contentId, contentPopularity);
	}

	public void decreasePopularity(String contentId) {
		Optional<ContentPopularity> contentPopularityOptional = Optional.ofNullable(POPULARITY_STORE.get(contentId));
		if (contentPopularityOptional.isEmpty()) {
			System.out.println("Bad Request");
			return;
		}
		ContentPopularity contentPopularity = contentPopularityOptional.get();
		if (contentPopularity.getPopularity() <= 0) {
			System.out.println("Content not found");
			return;
		}
		QUEUE.remove(contentPopularity);
		contentPopularity.setPopularity(contentPopularity.getPopularity() - 1);
		if (contentPopularity.getPopularity() == 0) {
			POPULARITY_STORE.remove(contentId);
			return;
		}
		QUEUE.offer(contentPopularity);
		POPULARITY_STORE.put(contentId, contentPopularity);
	}

	public String getMostPopularContent() {
		if (QUEUE.isEmpty())
			return null;
		return QUEUE.peek().getContentId();
	}

}
