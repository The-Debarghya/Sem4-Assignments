#!/usr/bin/env python3
import json

response = """{
    'fullname': 'Alessandra',
    'age': 41,
    'phone-numbers': ['+447421234567', '+447423456789'],
    'residence': {
        'address': {
            'first-line': 'Alexandra Rd',
            'second-line': ''
        },
        'zip': 'N8 0PP',
        'city': 'London',
        'country': 'UK'
    }
}"""

# JSON requires double-quotes, not single-quotes.
response = response.replace("'", '"')
response = json.loads(response)
print(f"Name: {response['fullname']}, Age: {response['age']}, Ph.No.: {response['phone-numbers'][0]}, {response['phone-numbers'][1]}")
print(
    f"Address: {response['residence']['address']['first-line']}, {response['residence']['zip']}, {response['residence']['city']}, {response['residence']['country']}")
