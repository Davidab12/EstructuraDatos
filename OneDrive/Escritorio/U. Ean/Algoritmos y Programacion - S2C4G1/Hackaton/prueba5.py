
dados = ""

while dados != "0 0 0 0":
    dados = input()
    a,b,c,d = dados.split(" ")
    if (1 <= int(a) <= 6) and (1 <= int(b) <= 6) and (1 <= int(c) <= 6) and (1 <= int(d) <= 6):

        if (a == "1" and b =="2") or (a == "2" and b =="1"):
            print("Player 1 wins.")

        elif (c == "1" and d =="2") or (c == "2" and d =="1"):
            print("Player 2 wins.")


        elif a == b and c != d:
            print("Player 1 wins.")

        elif c == d and a != b:
            print("Player 2 wins.")

        elif c == d and a == b:
            if int(c)+int(d) > int(a)+int(b):
                print("Player 2 wins.")
            elif int(c)+int(d) < int(a)+int(b):
                print("Player 1 wins.")

        elif (a == d) and (b == c):
            print("Tie.")
        else:
            j1 = b+a
            j2 = d+c
            if int(j1) > int(j2):
                print("Player 1 wins.")
            else:
                print("Player 2 wins.")

