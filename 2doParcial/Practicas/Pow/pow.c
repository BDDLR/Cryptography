#include <stdlib.h>
#include <stdio.h>

int main(int argc, char const *argv[])
{
	long b;
	long e;
	long n;
	long c = 1;

	printf("Type the base: \n");
	scanf("%li", &b);

	printf("Type the exponent: \n");
	scanf("%li", &e);

	printf("Type the ring: \n");
	scanf("%li", &n);

	for (int i = 0; i < e; i++)
		c=(b*c)%n;

	printf("The result is: %li\n", c);

	return 0;
}