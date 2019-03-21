#include <iostream>
#include <cctype>
#include <cstdlib>

using namespace std;

void match(char, char&);
void error();
void Expr(char&);
void F(char&);
void G(char&);
void Term (char&);
void H(char&);
void Factor(char&);
void AddOp(char&);
void MulOp(char&);
void Number(char&);
void I(char&);
void Digit(char&);
void Error();

int main(void){
    char curr;
    cout << "Enter a string for parsing: ";
    cin.get(curr);
    Expr(curr);
    if (curr == '\n')
        cout << "String is in the language." << endl;
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

void Expr(char& curr)
{
    F(curr);
    Term(curr);
    G(curr);
}

void Term(char& curr)
{
    Factor(curr);
    H(curr);
}

void Number(char& curr)
{
    Digit(curr);
    I(curr);
}

void G(char& curr)
{
    if (curr == '+' || curr == '-')
    {
        AddOp(curr);
        Term(curr);
        G(curr);
    }
}

void F(char& curr)
{
    if (curr == '+' || curr == '-')
    {
        AddOp(curr);
    }
}

void I(char& curr)
{
    if (isdigit(curr))
    {
        Digit(curr);
        I(curr);
    }
}

void H(char& curr)
{
    if(curr == '*' || curr == '/')
    {
        MulOp(curr);
        Factor(curr);
        H(curr);
    }
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

void Factor(char& curr)
{
    if(isdigit(curr))
    {
        Number(curr);
    }
    else if (curr == '(')
    {
        match('(', curr);
        Expr(curr);
        match(')', curr);
    }
    else
        error();
}

void MulOp(char& curr)
{
    if (curr == '*')
        match('*', curr);
    else if(curr == '/')
        match('/', curr);
    else
        error();
}
void AddOp(char& curr)
{
    if (curr == '+')
        match('+', curr);
    else if (curr == '-')
        match('-', curr);
    else
        error();
}
