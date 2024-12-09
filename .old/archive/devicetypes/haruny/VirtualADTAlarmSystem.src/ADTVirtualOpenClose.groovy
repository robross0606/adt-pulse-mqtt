/**
 *   Virtual ADT Open/Closed Sensor
 *
 *  Copyright 2018 Harun Yayli
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 */


metadata {
	definition(name: "Virtual ADT Open/Closed Sensor", namespace: "haruny", author: "Harun Yayli") {
		capability "Contact Sensor"
		capability "doorControl"

    }

	simulator {
		status "open": "open"
		status "closed": "closed"

	}

	tiles(scale: 2) {
		multiAttributeTile(name: "contact", type: "generic", width: 6, height: 4) {
			tileAttribute("device.contact", key: "PRIMARY_CONTROL") {
				attributeState "open", label: '${name}', icon: "st.contact.contact.open", backgroundColor: "#e86d13"
				attributeState "closed", label: '${name}', icon: "st.contact.contact.closed", backgroundColor: "#00A0DC"
			}
		}

		main("contact")
		details("contact")
	}
}

def parse(String description) {
	log.debug "description: $description"

	if (description.startsWith("open")){
		return createEvent(name:"contact", value:"open")
    }

	if (description.startsWith("closed")){
		return createEvent(name:"contact", value:"closed")
    }

return result
}

def open(){
	parse("open")
    sendEvent(name:"contact", value:"open")
}

def close(){
	parse("closed")
    sendEvent(name:"contact", value:"closed")
}
