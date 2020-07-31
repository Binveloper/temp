package siru.md.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data //dto�϶��� �� ����� ��
@AllArgsConstructor //������ ������ִ°�

public class ChartVo {
	private String item;
	private int number;
	
	@Override //tip >>>>> �����͸� ������ �� ���ϰ� �����Ϸ���
	public String toString() {
		return "Vo4GoogleChart item: " + item + ", number: " + number;
	}
}
