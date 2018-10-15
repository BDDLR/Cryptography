#include <stdio.h>
#include <stdlib.h>

int main(int argc, char const *argv[])
{
	unsigned char data [] = {0x68, 0x69};										// Source array
	unsigned char permutation [] = {3,4,5,6,12,0,7,15,13,8,1,11,9,10,14,12};	//Permutation array
	unsigned char output [2] = {0};									// Result array
	
	for (int k = 128, i = 0; i < sizeof(permutation); i++)
	{

		char a = permutation[i];
		char residuo = a & 7;
		char resultado = (a & 8) >> 3;
		char des = (1 << residuo);
		//char bit = data[resultado] & des;

		for (int j = 0; j < 2; j++)
		{
			if(i < 7){
				if(data[resultado] & des){
					output[0] = output[0] | k;
					break;
				}	
			}else{
				if(data[resultado] & des){
					output[1] = output[1] | k;
					break;
				}	
			}
			
		}

		k = k >> 1;

	}

	printf("%X %X\n", output[0], output[1]);

	return 0;
}