package GameConfig;

import java.util.Comparator;

public class SortTime implements Comparator<Ranking> {

	public int compare(Ranking o1, Ranking o2) {
		
		return o1.getTime() - o2.getTime();
	}

}
