# -*- coding: utf-8 -*-
import math,string,itertools,fractions,heapq,collections,re,array,bisect
import sys
from Queue import PriorityQueue

class DoubleWeights:
    def minimalCost(self, weight1, weight2):
        graph = dict()
        todo = PriorityQueue()
        visited = [0]*len(weight1)

        graph[(0, 0)] = 0
        visited[0] = 2
        todo.put((0, (0, 0)))

        while not todo.empty():
            sum_w2, (node_id, sum_w1) = todo.get(block=False)
            visited[node_id] += 1

            for i, (w1, w2) in enumerate(zip(weight1[node_id], weight2[node_id])):
                if w1 != '.' and visited[i] < 2:
                    todo.put((sum_w2+int(w2), (i, sum_w1 + int(w1))), block=False)
                    graph[(i, sum_w1 + int(w1))] = sum_w2+int(w2)

        min_w = sys.maxsize
        for key, value in graph.items():
            if key[0] == 1:
                min_w = min(min_w, value*key[1])

        if min_w == sys.maxsize:
            min_w = -1

        return min_w

# CUT begin
# TEST CODE FOR PYTHON {{{
import sys, time, math

def tc_equal(expected, received):
    try:
        _t = type(expected)
        received = _t(received)
        if _t == list or _t == tuple:
            if len(expected) != len(received): return False
            return all(tc_equal(e, r) for (e, r) in zip(expected, received))
        elif _t == float:
            eps = 1e-9
            d = abs(received - expected)
            return not math.isnan(received) and not math.isnan(expected) and d <= eps * max(1.0, abs(expected))
        else:
            return expected == received
    except:
        return False

def pretty_str(x):
    if type(x) == str:
        return '"%s"' % x
    elif type(x) == tuple:
        return '(%s)' % (','.join( (pretty_str(y) for y in x) ) )
    else:
        return str(x)

def do_test(weight1, weight2, __expected):
    startTime = time.time()
    instance = DoubleWeights()
    exception = None
    try:
        __result = instance.minimalCost(weight1, weight2);
    except:
        import traceback
        exception = traceback.format_exc()
    elapsed = time.time() - startTime   # in sec

    if exception is not None:
        sys.stdout.write("RUNTIME ERROR: \n")
        sys.stdout.write(exception + "\n")
        return 0

    if tc_equal(__expected, __result):
        sys.stdout.write("PASSED! " + ("(%.3f seconds)" % elapsed) + "\n")
        return 1
    else:
        sys.stdout.write("FAILED! " + ("(%.3f seconds)" % elapsed) + "\n")
        sys.stdout.write("           Expected: " + pretty_str(__expected) + "\n")
        sys.stdout.write("           Received: " + pretty_str(__result) + "\n")
        return 0

def run_tests():
    sys.stdout.write("DoubleWeights (500 Points)\n\n")

    passed = cases = 0
    case_set = set()
    for arg in sys.argv[1:]:
        case_set.add(int(arg))

    with open("DoubleWeights.sample", "r") as f:
        while True:
            label = f.readline()
            if not label.startswith("--"): break

            weight1 = []
            for i in range(0, int(f.readline())):
                weight1.append(f.readline().rstrip())
            weight1 = tuple(weight1)
            weight2 = []
            for i in range(0, int(f.readline())):
                weight2.append(f.readline().rstrip())
            weight2 = tuple(weight2)
            f.readline()
            __answer = int(f.readline().rstrip())

            cases += 1
            if len(case_set) > 0 and (cases - 1) in case_set: continue
            sys.stdout.write("  Testcase #%d ... " % (cases - 1))
            passed += do_test(weight1, weight2, __answer)

    sys.stdout.write("\nPassed : %d / %d cases\n" % (passed, cases))

    T = time.time() - 1489952903
    PT, TT = (T / 60.0, 75.0)
    points = 500 * (0.3 + (0.7 * TT * TT) / (10.0 * PT * PT + TT * TT))
    sys.stdout.write("Time   : %d minutes %d secs\n" % (int(T/60), T%60))
    sys.stdout.write("Score  : %.2f points\n" % points)

if __name__ == '__main__':
    print(sys.version)
    run_tests()

# }}}
# CUT end
