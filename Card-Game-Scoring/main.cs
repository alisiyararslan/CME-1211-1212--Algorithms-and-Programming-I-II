using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace homework2
{
    class Program
    {
        static void Main(string[] args)
        {
            

            string[,] slots = new string[9, 2];

            int counter = 0;
            Random rnd = new Random();
            int number1, number2;
            string control = "Y";
            while (control == "Y" || control == "y")
            {


                for (int i = 0; i < 9; i++)
                {

                    number1 = rnd.Next(1, 5);
                    number2 = rnd.Next(1, 4);

                    if (number2 == 1)
                    {

                        if (number1 == 1)
                        {

                            slots[i, 0] = "A ";
                            slots[i, 1] = "red";

                        }
                        if (number1 == 2)
                        {

                            slots[i, 0] = "B ";
                            slots[i, 1] = "red";
                        }
                        if (number1 == 3)
                        {

                            slots[i, 0] = "C ";
                            slots[i, 1] = "red";
                        }
                        if (number1 == 4)
                        {

                            slots[i, 0] = "D ";
                            slots[i, 1] = "red";
                        }

                    }

                    if (number2 == 2)
                    {

                        if (number1 == 1)
                        {
                            slots[i, 0] = "A ";
                            slots[i, 1] = "blue";
                        }
                        if (number1 == 2)
                        {
                            slots[i, 0] = "B ";
                            slots[i, 1] = "blue";
                        }
                        if (number1 == 3)
                        {
                            slots[i, 0] = "C ";
                            slots[i, 1] = "blue";
                        }
                        if (number1 == 4)
                        {
                            slots[i, 0] = "D ";
                            slots[i, 1] = "blue";
                        }

                    }

                    if (number2 == 3)
                    {

                        if (number1 == 1)
                        {
                            slots[i, 0] = "A ";
                            slots[i, 1] = "green";
                        }
                        if (number1 == 2)
                        {
                            slots[i, 0] = "B ";
                            slots[i, 1] = "green";
                        }
                        if (number1 == 3)
                        {
                            slots[i, 0] = "C ";
                            slots[i, 1] = "green";

                        }
                        if (number1 == 4)
                        {
                            slots[i, 0] = "D ";
                            slots[i, 1] = "green";

                        }
                    }

                }
                Console.Write("Randomly generated array: ");
                for (int i = 0; i < 9; i++)
                {

                    if (slots[i, 1] == "red")
                    {
                        Console.ForegroundColor = ConsoleColor.Red;
                        Console.Write(slots[i, 0]);
                    }
                    if (slots[i, 1] == "blue")
                    {
                        Console.ForegroundColor = ConsoleColor.Blue;
                        Console.Write(slots[i, 0]);
                    }
                    if (slots[i, 1] == "green")
                    {
                        Console.ForegroundColor = ConsoleColor.Green;
                        Console.Write(slots[i, 0]);
                    }

                }
                Console.WriteLine();
                int sum = 0;
                int sum2 = 0;
                int sum3 = 0;
                bool check = false;
                for (int i = 0; i < 7; i++)
                {
                    sum = 0;
                    if ((slots[i, 0] == slots[i + 1, 0]) && (slots[i + 1, 0] == slots[i + 2, 0]))
                    {
                        if ((slots[i, 1] == slots[i + 1, 1]) && (slots[i + 1, 1] == slots[i + 2, 1]))
                        {
                            sum = sum + 33;
                        }
                        if ((slots[i, 1] != slots[i + 1, 1]) && (slots[i + 1, 1] != slots[i + 2, 1]) && (slots[i, 1] != slots[i + 2, 1]))
                        {
                            sum = sum + 28;
                        }
                        if (((slots[i, 1] == slots[i + 1, 1]) && (slots[i + 1, 1] != slots[i + 2, 1])) || ((slots[i, 1] != slots[i + 1, 1]) && (slots[i + 1, 1] == slots[i + 2, 1])) || ((slots[i, 1] == slots[i + 2, 1]) && (slots[i + 1, 1] != slots[i + 2, 1])))
                        {
                            sum = sum + 22;
                        }
                    }
                    
                    else if ((slots[i, 1] == slots[i + 1, 1]) && (slots[i + 1, 1] == slots[i + 2, 1]))
                    {
                        if ((slots[i, 0] != slots[i + 1, 0]) && (slots[i + 1, 0] != slots[i + 2, 0]) && ((slots[i, 0] != slots[i + 2, 0])))
                        {
                            for (int j = 0; j < 3; j++)
                            {
                                if ((slots[i + j, 0] == "A ") || (slots[i + j, 0] == "B ") || (slots[i + j, 0] == "C "))
                                {
                                    sum3++;
                                }

                            }
                            if (sum3==3)
                            {
                                check = true;
                            }
                            sum3 = 0;
                            for (int j = 0; j < 3; j++)
                            {
                                if ((slots[i + j, 0] == "D ") || (slots[i + j, 0] == "B ") || (slots[i + j, 0] == "C "))
                                {
                                    sum3++;
                                }
                            }
                            if (sum3 == 3)
                            {
                                check = true;
                            }


                        }
                        if (check == true)
                        {
                            sum = sum + 18;
                        }
                        check = false;
                    }

                    else if ((slots[i, 1] != slots[i + 1, 1]) && (slots[i + 1, 1] != slots[i + 2, 1]) && (slots[i, 1] != slots[i + 2, 1]))
                    {
                        if ((slots[i, 0] != slots[i + 1, 0]) && (slots[i + 1, 0] != slots[i + 2, 0]) && ((slots[i, 0] != slots[i + 2, 0])))
                        {
                            for (int j = 0; j < 3; j++)
                            {
                                if ((slots[i + j, 0] == "A ") || (slots[i + j, 0] == "B ") || (slots[i + j, 0] == "C "))
                                {
                                    sum3++;
                                }

                            }
                            if (sum3 == 3)
                            {
                                check = true;
                            }
                            sum3 = 0;
                            for (int j = 0; j < 3; j++)
                            {
                                if ((slots[i + j, 0] == "D ") || (slots[i + j, 0] == "B ") || (slots[i + j, 0] == "C "))
                                {
                                    sum3++;
                                }
                            }
                            if (sum3 == 3)
                            {
                                check = true;
                            }
                        }
                        if (check == true)
                        {
                            sum = sum + 16;
                        }
                        check = false;
                    }
                    else if (((slots[i, 1] == slots[i + 1, 1]) && (slots[i + 1, 1] != slots[i + 2, 1])) || ((slots[i, 1] != slots[i + 1, 1]) && (slots[i + 1, 1] == slots[i + 2, 1])) || ((slots[i, 1] == slots[i + 2, 1]) && (slots[i + 1, 1] != slots[i + 2, 1])))
                    {
                        if ((slots[i, 0] != slots[i + 1, 0]) && (slots[i + 1, 0] != slots[i + 2, 0]) && ((slots[i, 0] != slots[i + 2, 0])))
                        {
                            for (int j = 0; j < 3; j++)
                            {
                                if ((slots[i + j, 0] == "A ") || (slots[i + j, 0] == "B ") || (slots[i + j, 0] == "C "))
                                {
                                    sum3++;
                                }

                            }
                            if (sum3 == 3)
                            {
                                check = true;
                            }
                            sum3 = 0;
                            for (int j = 0; j < 3; j++)
                            {
                                if ((slots[i + j, 0] == "D ") || (slots[i + j, 0] == "B ") || (slots[i + j, 0] == "C "))
                                {
                                    sum3++;
                                }
                            }
                            if (sum3 == 3)
                            {
                                check = true;
                            }
                        }
                        if (check == true)
                        {
                            sum = sum + 14;
                        }
                        check = false;
                    }
                    else if ((slots[i, 0] == slots[i + 1, 0]) && (slots[i + 1, 0] == slots[i + 2, 0]))
                    {
                        sum = sum + 12;
                    }
                    else if ((slots[i, 1] != slots[i + 1, 1]) && (slots[i + 1, 1] != slots[i + 2, 1]) && (slots[i, 1] != slots[i + 2, 1]))
                    {
                        sum = sum + 10;
                    }
                    sum2 = sum2 + sum;
                    if (sum != 0)
                    {
                        

                        for (int j = 0; j < 3; j++)
                        {
                            if (slots[i + j, 1] == "red")
                            {
                                Console.ForegroundColor = ConsoleColor.Red;
                                Console.Write(slots[i + j, 0]);
                            }
                            if (slots[i + j, 1] == "blue")
                            {
                                Console.ForegroundColor = ConsoleColor.Blue;
                                Console.Write(slots[i + j, 0]);
                            }
                            if (slots[i + j, 1] == "green")
                            {
                                Console.ForegroundColor = ConsoleColor.Green;
                                Console.Write(slots[i + j, 0]);
                            }
                        }
                        Console.ForegroundColor = ConsoleColor.White;
                        Console.WriteLine("  " + sum + "points");
                    }



                }
                Console.ForegroundColor = ConsoleColor.White;
                counter++;
                Console.WriteLine();
                Console.WriteLine("You get {0} points !!!", sum2);
                Console.WriteLine();
                Console.Write("Please enter your name: ");
                string name = Console.ReadLine();
                Console.WriteLine();

                //text file
                int[] scores = new int[20];
                string[] namess = new string[20];
                string[] asd = new string[10+counter];
                string[,] asd2 = new string[10+counter, 2];
                int q = 0;
                string str;

                StreamWriter file2 = File.AppendText("HighScoreTable.txt");
                file2.WriteLine(name+";"+sum2);
                file2.Close();

                
                StreamReader file1 = File.OpenText("HighScoreTable.txt");
                do
                {
                    str = file1.ReadLine();
                    
                    
                    asd[q] = str;
                    q++;
                } while (!file1.EndOfStream);
                file1.Close();

                    
                int r = 0;
                int p = 0;

                for (int w = 0; w < 10+counter; w++)
                {
                    string[] dizi = asd[w].Split(';');
                    foreach (string item in dizi)
                    {

                        asd2[r, p] = item;
                        if (p == 0)
                        {
                            p++;
                        }
                        else if (p == 1)
                        {
                            p--;
                            r++;
                        }


                    }
                    Console.WriteLine();

                }
                
                /* print first high score
                Console.WriteLine("---------------------");
                for (int w = 0; w < 10+counter; w++)
                {
                    for (int l = 0; l < 2; l++)
                    {
                        Console.Write(asd2[w, l] + "   ");

                    }
                    Console.WriteLine();
                }*/

                   
                for (int i = 0; i < asd2.GetLength(0); i++)
                {
                      namess[i]=asd2[i, 0];
                }

                for (int i = 0; i < asd2.GetLength(0); i++)
                {
                    scores[i] = Convert.ToInt32(asd2[i, 1]);
                }

                /* check namess and scores
                for (int i = 0; i < asd2.GetLength(0); i++)
                {
                    Console.WriteLine(namess[i]+"------");
                    Console.WriteLine(scores[i] + "++++++");
                }    */
                    

                
                
                

                
                /*
                StreamReader file3 =File.OpenText("C:\\Users\\Şiyar Arslan\\Desktop\\highscore.txt");

                int k = 0;
                do
                {
                    namess[k] = file3.ReadLine();
                    scores[k] = Convert.ToInt32(file3.ReadLine());
                    k++;

                } while (!file3.EndOfStream);
                file3.Close();*/


                //sort list
                int temp;
                string tempn;
                for (int i = 0; i < scores.Length; i++)
                {
                    for (int j = i+1; j < scores.Length; j++)
                    {
                        if (scores[j]>scores[i])
                        {
                            temp = scores[i];
                            scores[i] = scores[j];
                            scores[j] = temp;

                            tempn = namess[i];
                            namess[i] = namess[j];
                            namess[j] = tempn;
                        }
                    }
                }
                Console.WriteLine("High Score Table");
                for (int t = 0; t < 10; t++)
                {
                    Console.Write(namess[t] + "  ");
                    Console.WriteLine(scores[t]);
                }





                
                Console.WriteLine("Do you want to play again? (Y or N)");
                control = Console.ReadLine();


                


            }
















        }



    }
}
    

