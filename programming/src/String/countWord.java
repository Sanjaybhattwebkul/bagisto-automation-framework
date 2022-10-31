package String;

public class countWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello");
		String[] stringArr = null;
		String String = "the test string is the string the";
		stringArr = String.split(" ");
		for (int i = 0; i< stringArr.length; i++) {
			System.out.println(stringArr[i]);
		}
		
		
		/*$String = "the test string is the string the";

		$arr = explode(' ',$String);

		$array = array_flip(array_count_values($arr));

		ksort($array);

		$max = max(array_keys($array));

		$i = 1;

		foreach($array as $key => $row)
		{
		if($max > $key && (count($array)-1) == $i)
		{
		echo $key . ' - ' . $row;
		}

		$i++;
		}*/
	}

}
