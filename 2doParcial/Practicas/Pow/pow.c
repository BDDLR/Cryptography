#include <stdlib.h>
#include <stdio.h>

int main(int argc, char const *argv[])
{
	long b = 85;
	long e = 5;
	long n = 10;
	long c = 1;

	for (int i = 0; i < e; i++)
		c=(b*c)%n;

	printf("%li\n", c);

	return 0;
}