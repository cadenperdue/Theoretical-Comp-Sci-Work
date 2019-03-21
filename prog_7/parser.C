#include <iostream>
#include <cctype>
#include <cstdlib>
#include <string>
#include <sstream>

using namespace std;

void match(char, char&);
void error();
double Expr(char&);
double Term (char&);
double Factor(char&);
double Number(char&);
void Digit(char&);
void Error();

int main(void){
    char curr;
    cout << "Enter an expression: ";
    cin.get(curr);
    double expr = Expr(curr);
    if(curr == '\n')
        cout << "Expression evaluates to " << expr << endl;
    else 
        error();
}

void match(char lookahead, char& curr)
{
    if(curr == lookahead)
        cin.get(curr);
    else
        error();
}
void error(){
    cout << "syntax error" << endl;
    exit(1);
}

double Expr(char& curr)
{
    bool negative = false;
    double result;
    if (curr == '+' || curr == '-')
    {
         if (curr == '-')
             negative = true;
         match(curr, curr);
    }
    result = Term(curr);
    if (negative) result = -result;
    while (curr == '+' || curr == '-')
    {
        if (curr == '+')
        {
            match('+', curr);
            result = result + Term(curr);
        }
        else
        {
            match ('-', curr);
            result = result - Term(curr);
        }
    }
    return result;
}

double Term(char& curr)
{
    double result = Factor(curr);
    while (curr == '*' || curr == '/')
    {
        if (curr == '*')
        {
            match('*', curr);
            result = result * Factor(curr);
        }
        else 
        {
            match('/', curr);
            result = result / Factor(curr);
        }
    }
    return result;
}

double Number(char& curr)
{
    double result;
    cin.unget();
    cin >> result;
    cin.get(curr);
    return result;
}

void Digit(char& curr)
{
    if (isdigit(curr))
    {
        match(curr, curr);
    }
    else
        error();
}

double Factor(char& curr)
{
    double result;
    if(isdigit(curr))
    {
       result = Number(curr);
    }
    else if (curr == '(')
    {
        match('(', curr);
        result = Expr(curr);
        match(')', curr);
        return result;
    }
    else
        error();
}
