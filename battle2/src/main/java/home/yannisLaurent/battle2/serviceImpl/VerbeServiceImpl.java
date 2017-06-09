package home.yannisLaurent.battle2.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import home.yannisLaurent.battle2.business.Verbe;
import home.yannisLaurent.battle2.service.VerbeService;

public class VerbeServiceImpl implements VerbeService {

	List<Verbe> listeVerbe = new ArrayList<>();
	Verbe v0 = new Verbe("awake", "awoke", "awoken");
	Verbe v1 = new Verbe("become", "became", "become");
	Verbe v2 = new Verbe("cut", "cut", "cut");

	@Override
	public Verbe verbeAlea() {
		listeVerbe.add(v0);
		listeVerbe.add(v1);
		listeVerbe.add(v2);
		Random verbeRandom = new Random();
		int r = verbeRandom.nextInt(3);
		return listeVerbe.get(r);
	}

	@Override
	public List<Verbe> listeVerbe() {
		List<Verbe> etOuiCSimplissime = listeVerbe;
		listeVerbe.add(v0);
		listeVerbe.add(v1);
		listeVerbe.add(v2);
		return etOuiCSimplissime;
	}

}
