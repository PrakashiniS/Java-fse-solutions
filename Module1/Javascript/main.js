// Log welcome message to console
console.log("Welcome to the Community Portal");

// Add event listener for when the page is fully loaded
window.addEventListener('load', () => {
    alert("Welcome! The Community Portal is now fully loaded.");
});

// Event class with modern features
class Event {
    constructor({
        id,
        name,
        date,
        availableSeats = 50,
        location,
        image,
        fee = 25,
        category = 'general',
        registrations = []
    }) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.availableSeats = availableSeats;
        this.location = location;
        this.image = image;
        this.fee = fee;
        this.category = category;
        this.registrations = registrations;
    }

    // Check if event is available
    checkAvailability() {
        const today = new Date();
        const eventDate = new Date(this.date);
        return eventDate > today && this.availableSeats > 0;
    }

    // Register a user for the event
    registerUser({ name, email, phone, message = '' }) {
        if (!this.checkAvailability()) {
            throw new Error(`Event "${this.name}" is not available. Please check the date and available seats.`);
        }

        this.availableSeats--;
        this.registrations.push({
            name,
            email,
            phone,
            message,
            registrationDate: new Date().toISOString()
        });

        return {
            success: true,
            availableSeats: this.availableSeats,
            registrationCount: this.registrations.length
        };
    }

    // Get event details as formatted string
    getDetails() {
        const { name, date, location, availableSeats, fee, category, registrations } = this;
        return `
            Event: ${name}
            Date: ${date}
            Location: ${location}
            Available Seats: ${availableSeats}
            Fee: $${fee}
            Category: ${category}
            Total Registrations: ${registrations.length}
        `;
    }

    // Get event statistics
    getStats() {
        const { registrations, availableSeats, date } = this;
        return {
            totalRegistrations: registrations.length,
            availableSeats,
            isUpcoming: new Date(date) > new Date(),
            isFull: availableSeats === 0
        };
    }
}

// Event categories and their registration counters using closure
const createCategoryCounter = () => {
    const counters = {
        fair: 0,
        music: 0,
        food: 0,
        workshop: 0,
        sports: 0
    };

    return {
        increment: (category) => {
            counters[category] = (counters[category] || 0) + 1;
            return counters[category];
        },
        getCount: (category) => counters[category] || 0,
        getAllCounts: () => ({ ...counters })
    };
};

const categoryCounter = createCategoryCounter();

// Array of events with modern object initialization
const events = [
    new Event({
        id: 1,
        name: "Community Fair",
        date: "2024-06-15",
        location: "Central Park",
        image: "https://images.unsplash.com/photo-1511795409834-ef04bbd61622?w=500",
        category: "fair"
    }),
    new Event({
        id: 2,
        name: "Music Festival",
        date: "2024-07-20",
        location: "Downtown Square",
        image: "https://images.unsplash.com/photo-1470229722913-7c0e2dbbafd3?w=500",
        category: "music",
        fee: 50
    }),
    new Event({
        id: 3,
        name: "Food Festival",
        date: "2024-08-05",
        location: "Waterfront",
        image: "https://images.unsplash.com/photo-1504674900247-0877df9cc836?w=500",
        category: "food",
        availableSeats: 75
    })
];

// Array methods for event management with modern features
const eventManager = {
    // Add new event
    addEvent: (eventData) => {
        const newId = Math.max(...events.map(e => e.id)) + 1;
        const newEvent = new Event({ id: newId, ...eventData });
        events.push(newEvent);
        return newEvent;
    },

    // Get events by category
    getEventsByCategory: (category) => {
        return [...events].filter(event => event.category === category);
    },

    // Get upcoming events
    getUpcomingEvents: () => {
        const today = new Date();
        return [...events].filter(event => new Date(event.date) > today);
    },

    // Get events with available seats
    getAvailableEvents: () => {
        return [...events].filter(event => event.availableSeats > 0);
    },

    // Format event cards
    formatEventCards: () => {
        return events.map(({ id, name, date, location, availableSeats, fee, image, category, stats }) => ({
            id,
            title: `${name} - ${category.charAt(0).toUpperCase() + category.slice(1)} Event`,
            date: new Date(date).toLocaleDateString(),
            location,
            availableSeats,
            fee: `$${fee}`,
            image,
            category,
            stats
        }));
    },

    // Search events
    searchEvents: (query) => {
        const searchTerm = query.toLowerCase();
        return [...events].filter(event =>
            event.name.toLowerCase().includes(searchTerm) ||
            event.location.toLowerCase().includes(searchTerm) ||
            event.category.toLowerCase().includes(searchTerm)
        );
    },

    // Update event
    updateEvent: (id, updates) => {
        const index = events.findIndex(e => e.id === id);
        if (index !== -1) {
            events[index] = { ...events[index], ...updates };
            return events[index];
        }
        return null;
    },

    // Delete event
    deleteEvent: (id) => {
        const index = events.findIndex(e => e.id === id);
        if (index !== -1) {
            events.splice(index, 1);
            return true;
        }
        return false;
    }
};

// jQuery DOM manipulation
const jqueryManager = {
    // Initialize jQuery elements
    elements: {
        registerBtn: $('#registerBtn'),
        eventCards: $('.event-card'),
        confirmation: $('#confirmation'),
        form: $('#eventForm'),
        loadingSpinner: $('.loading-spinner')
    },

    // Initialize jQuery functionality
    initialize: () => {
        // Handle registration button click
        jqueryManager.elements.registerBtn.on('click', function (e) {
            e.preventDefault();
            debug.log('Registration button clicked');

            // Fade out current view
            jqueryManager.elements.eventCards.fadeOut(300, () => {
                // Show loading spinner
                jqueryManager.elements.loadingSpinner.fadeIn(300);

                // Process registration
                formHandler.handleSubmit(e).then(() => {
                    // Hide loading spinner
                    jqueryManager.elements.loadingSpinner.fadeOut(300, () => {
                        // Fade in updated view
                        jqueryManager.elements.eventCards.fadeIn(300);
                    });
                });
            });
        });

        // Add smooth scrolling
        $('a[href^="#"]').on('click', function (e) {
            e.preventDefault();
            const target = $($(this).attr('href'));
            if (target.length) {
                $('html, body').animate({
                    scrollTop: target.offset().top
                }, 500);
            }
        });
    },

    // Show confirmation message with animation
    showConfirmation: (message, type = 'success') => {
        const confirmation = jqueryManager.elements.confirmation;
        confirmation
            .removeClass('success-message error-message')
            .addClass(`${type}-message`)
            .text(message)
            .fadeIn(300)
            .delay(3000)
            .fadeOut(300);
    },

    // Update event card with animation
    updateEventCard: (eventId, updates) => {
        const card = $(`.event-card[data-event-id="${eventId}"]`);
        if (card.length) {
            card.fadeOut(300, () => {
                if (updates.availableSeats !== undefined) {
                    card.find('.seat-count').text(updates.availableSeats);
                }
                if (updates.totalRegistrations !== undefined) {
                    card.find('.registration-count').text(updates.totalRegistrations);
                }
                card.fadeIn(300);
            });
        }
    }
};

// Add jQuery styles
const jqueryStyles = `
    .fade-transition {
        transition: opacity 0.3s ease-in-out;
    }
    .fade-enter {
        opacity: 0;
    }
    .fade-enter-active {
        opacity: 1;
    }
    .fade-exit {
        opacity: 1;
    }
    .fade-exit-active {
        opacity: 0;
    }
`;

// Framework considerations
/*
Benefits of moving to React/Vue:

1. Component-Based Architecture:
   - Reusable UI components
   - Better code organization
   - Easier maintenance
   - Example React component:

   function EventCard({ event, onRegister }) {
     return (
       <div className="event-card">
         <img src={event.image} alt={event.title} />
         <h3>{event.title}</h3>
         <p>Date: {event.date}</p>
         <button onClick={() => onRegister(event.id)}>
           Register Now
         </button>
       </div>
     );
   }

2. Virtual DOM:
   - Efficient updates
   - Better performance
   - Automatic re-rendering
   - No manual DOM manipulation

3. State Management:
   - Centralized state
   - Predictable updates
   - Better debugging
   - Example Redux action:

   const registerUser = (userData) => ({
     type: 'REGISTER_USER',
     payload: userData
   });

4. Modern Development:
   - Hot reloading
   - Better tooling
   - TypeScript support
   - Testing utilities
*/

// Initialize the page
document.addEventListener('DOMContentLoaded', () => {
    // Add jQuery styles
    const styleJquery = document.createElement('style');
    styleJquery.textContent = jqueryStyles;
    document.head.appendChild(styleJquery);

    // Initialize jQuery functionality
    jqueryManager.initialize();

    // ... rest of the initialization code ...
}); 