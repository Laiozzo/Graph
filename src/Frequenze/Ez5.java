package Frequenze;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Ez5
{
	public Ez5()
	{
		HashMap<String, HashMap<String, Set<Permesso>>> user = new HashMap<>();
		HashMap<String, Set<Permesso>> permitUser = new HashMap<>();

		String rowFile = "Alice,LEGGERE,true";
		String[] splitRow = rowFile.split(",");

		//Alice inserito Hashmap "user"
		String name = splitRow[0];
		user.put(name, new HashMap<>());

		//temporanea "permitType" salvare il permesso
		String permitType = splitRow[1];
		if (permitType.equals("LEGGERE"))
		{	//salvo CHIAVE dell'hashmap interno (tipo permesso - String)
			permitUser.put(permitType, new HashSet<>());
			//salvo VALORE dell'hashmap interno (valore permesso - Set)
			permitUser.get(permitType).add(Permesso.valueOf(permitType));
		}
	}


	enum Permesso {
	 LEGGERE , SCRIVERE , ESEGUIRE
 	}
}



