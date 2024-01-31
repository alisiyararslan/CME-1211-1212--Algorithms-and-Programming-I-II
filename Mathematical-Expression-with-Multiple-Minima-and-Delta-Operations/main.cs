using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp5
{
    class Program
    {
        static void Main(string[] args)
        {
            double x;
            char oper;
            double sum = 0;
            double mul1 = 1;
            double mul2 = 1;
            double mul3 = 1;
            double factor = 1;
            double value1;
            double value2;
            double value3=0;
            double value4;
            Console.WriteLine("Please enter a number");
            x = Convert.ToDouble(Console.ReadLine());
            while ((x < 0) || (x > 25)) //the value of x must be  between 0 and 25
            {
                Console.WriteLine("Please enter another number");
                x = Convert.ToDouble(Console.ReadLine());
            }
            Console.WriteLine("Please enter an operator ");
            oper = Convert.ToChar(Console.ReadLine());
            while ((oper != '/' ) && (oper != '*' ))//the value of operation must be  "/" or "*"
            {
                Console.WriteLine("Please enter another  operator");
                oper = Convert.ToChar(Console.ReadLine());
            }

            for (int i = 1; i <= 30; i++)
            {
                int t = 4 * i - 1;
                mul1 = 1;//first "mul1" must be set to 1  because we don't want to use the remaining values from the previous operation.
                for (int j = 0; j < (3*i)-1; j++)
                {
                    mul1 = mul1 * x;//multiplies each x value that satisfies the condition
                }

                mul2 = 1;// "mul2" must be set to 1  because we don't want to use the remaining values from the previous operation.
                mul2 = (4 * i - 1) * mul1;
                factor = 1;// "factor" must be set to 1  because we don't want to use the remaining values from the previous operation.
                for (int j = 1; j <= (2*i)+2; j++)
                {
                    factor = factor * j;//multiplies each j value that satisfies the condition
                }

                if (factor < mul2)//Determine the smaller of "factor" and "mul2" values
                    value1 = factor;
                else
                    value1 = mul2;
                if (oper == '/')
                    value2 = value1 / (5 * i - 3);
                else
                    value2=value1* (5 * i - 3);
                value3 = 0;// "value3" must be set to 0  because we don't want to use the remaining values from the previous operation.
                mul3 = 1;// "mul3" must be set to 1  because we don't want to use the remaining values from the previous operation.
                for (int j = 2*i; j <= 4*i; j+=2)
                {
                    mul3 = 1;// "mul3" must be set to 1  because we don't want to use the remaining values from the previous operation.
                    for (int p = 1; p <= i+1; p++)
                    {
                        mul3 = mul3 * j;//multiplies each j value that satisfies the condition

                    }
                    
                    value3 = value3 + mul3;// adds each mul3 value that satisfies the condition
                }
                value4 = 1;
                value4 = value2 / value3;

                if (i % 2 == 1)
                    sum = sum + value4;//the odd-numbered term adds up
                else
                    sum = sum - value4;//the even-numbered term is subtracted









            }
            
            
            Console.WriteLine();
            Console.WriteLine();
            Console.Write("The result: ");
            Console.WriteLine(sum);


            Console.ReadKey();
        }
    }
}
