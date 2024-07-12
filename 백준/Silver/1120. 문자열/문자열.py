import sys

a, b = sys.stdin.readline().split()                                                     # 두 문자열 입력

answer = []                                                                             # 각각의 경우를 담을 배열

for i in range(len(b) - len(a) + 1):                                                    # a길이를 제외한 b길이만큼 반복
    cnt = 0

    for j in range(len(a)):                                                             # 바꿔야 하는 단어 개수 세기
        if a[j] != b[i + j]:
            cnt += 1                                                                    # 문자가 다를경우 cnt 1 증가
    answer.append(cnt)                                                                  # 바꿔야 하는 단어 개수의 경우 배열에 담기

print(min(answer))      