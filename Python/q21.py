#!/usr/bin/env python3
from nose.tools import assert_equal
import parameterized
import math

#https://pypi.org/project/parameterized/


@parameterized([
    (2, 2, 4),
    (2, 3, 8),
    (1, 9, 1),
    (0, 9, 0)
])
def test_pow(base, exponent, expected):
    assert_equal(math.pow(base, exponent), expected)
