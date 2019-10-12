#include <iostream>
#include <unordered_set>

using namespace std;

int main()
{
    unordered_set<int> intersect; // set to hold intersection items
    unordered_set<int> diff;      // set to hold difference items

    // initialization
    unordered_set<int> s1{1, 5, 3, 6, 7, 8};
    unordered_set<int> s2{2, 5, 6, 9, 7};

    // set difference : loop through s1 to check if s2 does not contain s1 elements
    for (int num1 : s1)
    {
        if (!s2.count(num1))
        {
            diff.insert(num1);
        }
    }

    // set intersection : loop through s2 to check if s1 contains s2 elements
    for (int num2 : s2)
    {
        if (s1.count(num2))
        {
            intersect.insert(num2);
        }
    }

    // log result~s
    cout
        << "\n*********C++ Results***********" << endl;
    cout << "Set Difference = "
         << "[";
    for (int i : diff)
    {
        cout << i << " ";
    }
    cout << "]" << endl;

    cout << "Set Intersection = "
         << "[";
    for (int i : intersect)
    {
        cout << i << " ";
    }
    cout << "]" << endl;
}