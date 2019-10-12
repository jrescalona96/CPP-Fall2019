#include <iostream>
#include <iomanip>

int increment() {
    static int a = 10;
    return a++;
}

int main () {
    for(int i = 0; i <100; i++) {
        std::cout << increment() << std::endl;
    }

}